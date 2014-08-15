// automatically generated, do not modify

package AddressBook.Example;

import java.nio.*;
import java.lang.*;
import java.util.*;
import flatbuffers.*;

public class PhoneNumber extends Table {
  public PhoneNumber __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }
  public String number() { int o = __offset(4); return o != 0 ? __string(o) : null; }
  public byte type() { int o = __offset(6); return o != 0 ? bb.get(o + bb_pos) : 2; }

  public static void startPhoneNumber(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addNumber(FlatBufferBuilder builder, int numberOffset) { builder.addOffset(0, numberOffset, 0); }
  public static void addType(FlatBufferBuilder builder, byte type) { builder.addByte(1, type, 2); }
  public static int endPhoneNumber(FlatBufferBuilder builder) { return builder.endObject(); }
};

