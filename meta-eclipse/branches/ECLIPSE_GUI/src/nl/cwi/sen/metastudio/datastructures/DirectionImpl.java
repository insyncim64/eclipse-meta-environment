package nl.cwi.sen.metastudio.datastructures;

import java.io.IOException;
import java.io.InputStream;

abstract public class DirectionImpl extends DatastructuresConstructor
{
  public static Direction fromString(String str)
  {
    aterm.ATerm trm = getStaticDatastructuresFactory().parse(str);
    return fromTerm(trm);
  }
  public static Direction fromTextFile(InputStream stream) throws aterm.ParseError, IOException
  {
    aterm.ATerm trm = getStaticDatastructuresFactory().readFromTextFile(stream);
    return fromTerm(trm);
  }
  public boolean isEqual(Direction peer)
  {
    return term.isEqual(peer.toTerm());
  }
  public static Direction fromTerm(aterm.ATerm trm)
  {
    Direction tmp;
    if ((tmp = Direction_Forward.fromTerm(trm)) != null) {
      return tmp;
    }

    if ((tmp = Direction_Back.fromTerm(trm)) != null) {
      return tmp;
    }

    if ((tmp = Direction_Both.fromTerm(trm)) != null) {
      return tmp;
    }

    if ((tmp = Direction_None.fromTerm(trm)) != null) {
      return tmp;
    }


    throw new RuntimeException("This is not a Direction: " + trm);
  }

  public boolean isDirection()  {
    return true;
  }

  public boolean isForward()
  {
    return false;
  }

  public boolean isBack()
  {
    return false;
  }

  public boolean isBoth()
  {
    return false;
  }

  public boolean isNone()
  {
    return false;
  }


}

