import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "akshita",comments = "Main method",date = "Dec 17 2023",revision = 1)
    public String toString()
    {
        return "Overridden string";
    }
    @Deprecated
    @MethodInfo(comments = "deprecated method",date = "Dec 17,2023")
    public static void oldMethod()
    {
        System.out.println("Old Method, dont use");
    }
    public static void main(String[] args)
    {
        try{
            for(Method method:AnnotationExample.class.getMethods())
            {
                if(method.isAnnotationPresent(MethodInfo.class))
                {
                    try {
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in method: " + method + " : " + anno);
                        }
                        MethodInfo methodanno = method.getAnnotation(MethodInfo.class);
                        if (methodanno.revision() == 1) {
                            System.out.println("Method anno with revision = 1 : " + method);
                        }
                    }catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
