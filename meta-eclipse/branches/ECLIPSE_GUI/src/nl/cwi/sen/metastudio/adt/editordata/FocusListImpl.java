package nl.cwi.sen.metastudio.adt.editordata;


abstract public class FocusListImpl extends EditorDataConstructor
{
  protected FocusListImpl(EditorDataFactory factory) {
     super(factory);
  }
  protected void init(int hashCode, aterm.ATermList annos, aterm.AFun fun,	aterm.ATerm[] args) {
    super.init(hashCode, annos, fun, args);
  }
  protected void initHashCode(aterm.ATermList annos, aterm.AFun fun, aterm.ATerm[] i_args) {
  	super.initHashCode(annos, fun, i_args);
  }
  public boolean isEqual(FocusList peer)
  {
    return super.isEqual(peer);
  }
  public boolean isSortFocusList()  {
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

  public Focus getHead()
  {
     throw new UnsupportedOperationException("This FocusList has no Head");
  }

  public FocusList setHead(Focus _head)
  {
     throw new IllegalArgumentException("Illegal argument: " + _head);
  }

  public FocusList getTail()
  {
     throw new UnsupportedOperationException("This FocusList has no Tail");
  }

  public FocusList setTail(FocusList _tail)
  {
     throw new IllegalArgumentException("Illegal argument: " + _tail);
  }

}

