// File generated by hadoop record compiler. Do not edit.
package org.apache.zookeeper.proto;

import java.util.*;
import org.apache.jute.*;
public class GetDataResponse implements Record {
  private byte[] data;
  private org.apache.zookeeper.data.Stat stat;
  public GetDataResponse() {
  }
  public GetDataResponse(
        byte[] data,
        org.apache.zookeeper.data.Stat stat) {
    this.data=data;
    this.stat=stat;
  }
  public byte[] getData() {
    return data;
  }
  public void setData(byte[] m_) {
    data=m_;
  }
  public org.apache.zookeeper.data.Stat getStat() {
    return stat;
  }
  public void setStat(org.apache.zookeeper.data.Stat m_) {
    stat=m_;
  }
  public void serialize(OutputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(this,tag);
    a_.writeBuffer(data,"data");
    a_.writeRecord(stat,"stat");
    a_.endRecord(this,tag);
  }
  public void deserialize(InputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(tag);
    data=a_.readBuffer("data");
    stat= new org.apache.zookeeper.data.Stat();
    a_.readRecord(stat,"stat");
    a_.endRecord(tag);
}
  public String toString() {
    try {
      java.io.ByteArrayOutputStream s =
        new java.io.ByteArrayOutputStream();
      CsvOutputArchive a_ = 
        new CsvOutputArchive(s);
      a_.startRecord(this,"");
    a_.writeBuffer(data,"data");
    a_.writeRecord(stat,"stat");
      a_.endRecord(this,"");
      return new String(s.toByteArray(), "UTF-8");
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
    return "ERROR";
  }
  public void write(java.io.DataOutput out) throws java.io.IOException {
    BinaryOutputArchive archive = new BinaryOutputArchive(out);
    serialize(archive, "");
  }
  public void readFields(java.io.DataInput in) throws java.io.IOException {
    BinaryInputArchive archive = new BinaryInputArchive(in);
    deserialize(archive, "");
  }
  public int compareTo (Object peer_) throws ClassCastException {
    if (!(peer_ instanceof GetDataResponse)) {
      throw new ClassCastException("Comparing different types of records.");
    }
    GetDataResponse peer = (GetDataResponse) peer_;
    int ret = 0;
    {
      byte[] my = data;
      byte[] ur = peer.data;
      ret = org.apache.jute.Utils.compareBytes(my,0,my.length,ur,0,ur.length);
    }
    if (ret != 0) return ret;
    ret = stat.compareTo(peer.stat);
    if (ret != 0) return ret;
     return ret;
  }
  public boolean equals(Object peer_) {
    if (!(peer_ instanceof GetDataResponse)) {
      return false;
    }
    if (peer_ == this) {
      return true;
    }
    GetDataResponse peer = (GetDataResponse) peer_;
    boolean ret = false;
    ret = org.apache.jute.Utils.bufEquals(data,peer.data);
    if (!ret) return ret;
    ret = stat.equals(peer.stat);
    if (!ret) return ret;
     return ret;
  }
  public int hashCode() {
    int result = 17;
    int ret;
    ret = Arrays.toString(data).hashCode();
    result = 37*result + ret;
    ret = stat.hashCode();
    result = 37*result + ret;
    return result;
  }
  public static String signature() {
    return "LGetDataResponse(BLStat(lllliiiliil))";
  }
}