package nl.cwi.sen.metastudio.datastructures;

import java.io.IOException;
import java.io.InputStream;

abstract public class PolygonImpl extends DatastructuresConstructor
{
  public static Polygon fromString(String str)
  {
    aterm.ATerm trm = getStaticDatastructuresFactory().parse(str);
    return fromTerm(trm);
  }
  public static Polygon fromTextFile(InputStream stream) throws aterm.ParseError, IOException
  {
    aterm.ATerm trm = getStaticDatastructuresFactory().readFromTextFile(stream);
    return fromTerm(trm);
  }
  public boolean isEqual(Polygon peer)
  {
    return term.isEqual(peer.toTerm());
  }
  public static Polygon fromTerm(aterm.ATerm trm)
  {
    Polygon tmp;
    if ((tmp = Polygon_Empty.fromTerm(trm)) != null) {
      return tmp;
    }

    if ((tmp = Polygon_Multi.fromTerm(trm)) != null) {
      return tmp;
    }


    throw new RuntimeException("This is not a Polygon: " + trm);
  }

  public boolean isPolygon()  {
    return true;
  }

  public boolean isEmpty()
  {
    return false;
  }

  public boolean isMulti()
  {
    return false;
  }

  public boolean hasHead()
  {
    return false;
  }

  public boolean hasTail()
  {
    return false;
  }

  public Point getHead()
  {
     throw new RuntimeException("This Polygon has no Head");
  }

  public Polygon setHead(Point _head)
  {
     throw new RuntimeException("This Polygon has no Head");
  }

  public Polygon getTail()
  {
     throw new RuntimeException("This Polygon has no Tail");
  }

  public Polygon setTail(Polygon _tail)
  {
     throw new RuntimeException("This Polygon has no Tail");
  }


}

