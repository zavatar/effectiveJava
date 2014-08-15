import AddressBook.Example.AddressBook;
import AddressBook.Example.Person;
import AddressBook.Example.PhoneNumber;
import AddressBook.Example.PhoneType;
import flatbuffers.FlatBufferBuilder;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/**
 * Created by zhumeng on 2014/8/13.
 */
public class FlatBufferAddressBook {

    private static String NAME1 = "zhumeng";
    private static String EMAIL1 = "bjzhumeng@corp.netease.com";
    private static String PHONE1 = "18910690027";

    private static String NAME2 = "Meng Zhu";
    private static String EMAIL2 = "zhumeng1989@gmail.com";
    private static String PHONE2 = "15658076066";

    public static void main(String[] args) {
        FlatBufferBuilder fbb = new FlatBufferBuilder(1);

        int idx1 = fbb.createString(PHONE1);
        int idx2 = fbb.createString(PHONE2);

        // Phone1
        PhoneNumber.startPhoneNumber(fbb);
        PhoneNumber.addNumber(fbb, idx1);
        PhoneNumber.addType(fbb, PhoneType.WORK);
        idx1 = PhoneNumber.endPhoneNumber(fbb);

        // Phone2
        PhoneNumber.startPhoneNumber(fbb);
        PhoneNumber.addNumber(fbb, idx2);
        PhoneNumber.addType(fbb, PhoneType.HOME);
        idx2 = PhoneNumber.endPhoneNumber(fbb);

        int email1 = fbb.createString(EMAIL1);
        int name1 = fbb.createString(NAME1);
        // Person1
        Person.startPerson(fbb);
        Person.addEmail(fbb, email1);
        Person.addId(fbb, 1);
        Person.addName(fbb, name1);
        Person.addPhone(fbb, idx1);
        idx1 = Person.endPerson(fbb);

        int email2 = fbb.createString(EMAIL2);
        int name2 = fbb.createString(NAME2);
        // Person2
        Person.startPerson(fbb);
        Person.addPhone(fbb, idx2);
        Person.addName(fbb, name2);
        Person.addId(fbb, 2);
        Person.addEmail(fbb, email2);
        idx2 = Person.endPerson(fbb);

        // PersonVector
        AddressBook.startPersonVector(fbb, 2);
        fbb.addOffset(idx2);
        fbb.addOffset(idx1);
        idx1 = fbb.endVector();

        // AddressBook
        AddressBook.startAddressBook(fbb);
        AddressBook.addPerson(fbb, idx1);
        int add = AddressBook.endAddressBook(fbb);

        fbb.finish(add);

        try {
            DataOutputStream os = new DataOutputStream(new FileOutputStream(
                    "addressbook_java.bin"));
            os.write(fbb.dataBuffer().array(), fbb.dataStart(), fbb.offset());
            os.close();
        } catch(java.io.IOException e) {
            System.out.println("FlatBuffers test: couldn't write file");
            return;
        }

        byte[] data;
        File file = new File("addressbook_java.bin");
        RandomAccessFile f;
        try {
            f = new RandomAccessFile(file, "r");
            data = new byte[(int)f.length()];
            f.readFully(data);
            f.close();
        } catch(java.io.IOException e) {
            System.out.println("FlatBuffers test: couldn't read file");
            return;
        }

        ByteBuffer bb = ByteBuffer.wrap(data);
        TestBuffer(bb, 0);
    }

    static void TestBuffer(ByteBuffer bb, int start) {
        AddressBook ab = AddressBook.getRootAsAddressBook(bb, start);

        Person person1 = ab.person(0);
        Person person2 = ab.person(1);

        System.out.println(person1.id() + ", " + person1.name() + ", " + person1.email() + ", " + person1.phone().number());
        System.out.println(person2.id() + ", " + person2.name() + ", " + person2.email() + ", " + person2.phone().number());
    }
}
