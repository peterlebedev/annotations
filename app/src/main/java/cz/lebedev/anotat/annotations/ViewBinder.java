package cz.lebedev.anotat.annotations;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author petersimko.
 */
public class ViewBinder {

    public static void bind(Activity target){
        bindViews(target, target.getClass().getDeclaredFields(),target.getWindow().getDecorView().getRootView());

    }

    private static void bindViews(Object object, Field[] declaredFields, View rootView) {
        for(Field field : declaredFields){
            Annotation annotation = field.getAnnotation(MyBindView.class);
            if(annotation!=null){
                MyBindView myBindView = (MyBindView)annotation;
                int id = myBindView.value();
                View viewById = rootView.findViewById(id);
                try {
                    field.setAccessible(true);
                    field.set(object, viewById);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }

        }


    }

}
