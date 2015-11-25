package Adapters;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * Created by KESHAV JHA on 11/19/2015.
 */
public class SaveVal {

    Context c;
    public SaveVal(Context c)
    {
     this.c=c;
    }

    public void save(String valueToSave)
    {
        SharedPreferences sp91 = c.getSharedPreferences("grossinfo", c.MODE_PRIVATE);
        SharedPreferences.Editor ed11 = sp91.edit();
        ed11.putString("res", valueToSave);
        ed11.commit();
    }

    public String getVal()
    {
        SharedPreferences sp91 = c.getSharedPreferences("grossinfo", c.MODE_PRIVATE);
        return  sp91.getString("res","no value");


    }


public void clearval()
{
    SharedPreferences sp91 = c.getSharedPreferences("grossinfo", c.MODE_PRIVATE);
    SharedPreferences.Editor ed11 = sp91.edit();
    ed11.putString("res"," ");
    ed11.commit();
}


}
