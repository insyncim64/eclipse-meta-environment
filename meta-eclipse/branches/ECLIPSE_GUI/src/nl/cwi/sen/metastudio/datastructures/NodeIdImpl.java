package nl.cwi.sen.metastudio.datastructures;

import java.io.IOException;
import java.io.InputStream;

abstract public class NodeIdImpl extends DatastructuresConstructor
{
  public static NodeId fromString(String str)
  {
    aterm.ATerm trm = getStaticDatastructuresFactory().parse(str);
    return fromTerm(trm);
  }
  public static NodeId fromTextFile(InputStream stream) throws aterm.ParseError, IOException
  {
    aterm.ATerm trm = getStaticDatastructuresFactory().readFromTextFile(stream);
    return fromTerm(trm);
  }
  public boolean isEqual(NodeId peer)
  {
    return term.isEqual(peer.toTerm());
  }
  public static NodeId fromTerm(aterm.ATerm trm)
  {
    NodeId tmp;
    if ((tmp = NodeId_Default.fromTerm(trm)) != null) {
      return tmp;
    }


    throw new RuntimeException("This is not a NodeId: " + trm);
  }

  public boolean isNodeId()  {
    return true;
  }

  public boolean isDefault()
  {
    return false;
  }

  public boolean hasId()
  {
    return false;
  }

  public String getId()
  {
     throw new RuntimeException("This NodeId has no Id");
  }

  public NodeId setId(String _id)
  {
     throw new RuntimeException("This NodeId has no Id");
  }


}

