package nl.cwi.sen.metastudio.datastructures;

import java.io.IOException;
import java.io.InputStream;

abstract public class NodeImpl extends DatastructuresConstructor
{
  public static Node fromString(String str)
  {
    aterm.ATerm trm = getStaticDatastructuresFactory().parse(str);
    return fromTerm(trm);
  }
  public static Node fromTextFile(InputStream stream) throws aterm.ParseError, IOException
  {
    aterm.ATerm trm = getStaticDatastructuresFactory().readFromTextFile(stream);
    return fromTerm(trm);
  }
  public boolean isEqual(Node peer)
  {
    return term.isEqual(peer.toTerm());
  }
  public static Node fromTerm(aterm.ATerm trm)
  {
    Node tmp;
    if ((tmp = Node_Default.fromTerm(trm)) != null) {
      return tmp;
    }


    throw new RuntimeException("This is not a Node: " + trm);
  }

  public boolean isNode()  {
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

  public boolean hasAttributes()
  {
    return false;
  }

  public NodeId getId()
  {
     throw new RuntimeException("This Node has no Id");
  }

  public Node setId(NodeId _id)
  {
     throw new RuntimeException("This Node has no Id");
  }

  public AttributeList getAttributes()
  {
     throw new RuntimeException("This Node has no Attributes");
  }

  public Node setAttributes(AttributeList _attributes)
  {
     throw new RuntimeException("This Node has no Attributes");
  }


}

