// automatically generated, do not modify

package AddressBook.Example;

import java.nio.*;
import java.lang.*;
import java.util.*;
import flatbuffers.*;

public class AddressBook extends Table {
  public static AddressBook getRootAsAddressBook(ByteBuffer _bb, int offset) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (new AddressBook()).__init(_bb.getInt(offset) + offset, _bb); }
  public AddressBook __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }
  public Person person(int j) { return person(new Person(), j); }
  public Person person(Person obj, int j) { int o = __offset(4); return o != 0 ? obj.__init(__indirect(__vector(o) + j * 4), bb) : null; }
  public int personLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }

  public static void startAddressBook(FlatBufferBuilder builder) { builder.startObject(1); }
  public static void addPerson(FlatBufferBuilder builder, int personOffset) { builder.addOffset(0, personOffset, 0); }
  public static void startPersonVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems); }
  public static int endAddressBook(FlatBufferBuilder builder) { return builder.endObject(); }
};

