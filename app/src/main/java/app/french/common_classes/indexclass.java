package app.french.common_classes;

import app.french.common_adapters.BranchEnd;

public class indexclass {

    private int mLsnName;
    private String mLessonName;
    private int mLessonNum;
    private Class<?> mCls;

    public indexclass(int LsnName, int lessonNum){
        mLsnName = LsnName;
        mLessonName = null;
        mLessonNum = lessonNum;
        mCls = BranchEnd.class;
    }

    public indexclass(String lessonName, int lessonNum){
        mLessonName = lessonName;
        mLessonNum = lessonNum;
    }

    public indexclass(String lessonName, int lessonNum, Class<?> cls){
        mLessonName = lessonName;
        mCls = cls;
        mLessonNum = lessonNum;
    }

    public indexclass(int LsnName, int lessonNum, Class<?> cls){
        mLsnName = LsnName;
        mLessonName = null;
        mCls = cls;
        mLessonNum = lessonNum;
    }

    public int getmLsnName(){
        return mLsnName;
    }

    public Class<?> getmCls(){
        return mCls;
    }

    public String getmLessonName(){
        return mLessonName;
    }

    public  int getmLessonNum(){
        return mLessonNum;
    }


}
