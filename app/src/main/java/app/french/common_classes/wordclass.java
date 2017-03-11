package app.french.common_classes;

public class wordclass {

    private int mItemName;
    private int mBg;
    private Class<?> mCls;

    public wordclass(int itemName, int bg, Class<?> cls){
        mItemName = itemName;
        mBg = bg;
        mCls = cls;
    }
    public wordclass(int itemName, Class<?> cls){
        mItemName = itemName;
        mCls = cls;
    }

    public Class<?> getmCls(){
        return mCls;
    }

    public int getmItemName(){
        return mItemName;
    }

    public int getmBg(){
        return mBg;
    }

}
