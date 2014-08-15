// automatically generated, do not modify

package AddressBook.Example;

import java.nio.*;
import java.lang.*;
import java.util.*;
import flatbuffers.*;

public class Person extends Table {
  public Person __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }
  public String name() { int o = __offset(4); return o != 0 ? __string(o) : null; }
  public int id() { int o = __offset(6); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public String email() { int o = __offset(8); return o != 0 ? __string(o) : null; }
  public PhoneNumber phone() { return phone(new PhoneNumber()); }
  public PhoneNumber phone(PhoneNumber obj) { int o = __offset(10); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }

  public static void startPerson(FlatBufferBuilder builder) { builder.startObject(4); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addId(FlatBufferBuilder builder, int id) { builder.addInt(1, id, 0); }
  public static void addEmail(FlatBufferBuilder builder, int emailOffset) { builder.addOffset(2, emailOffset, 0); }
  public static void addPhone(FlatBufferBuilder builder, int phoneOffset) { builder.addOffset(3, phoneOffset, 0); }
  public static int endPerson(FlatBufferBuilder builder) { return builder.endObject(); }
};

