package dk.BrugtMarket.repository;

import javax.enterprise.context.Dependent;
import javax.interceptor.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Spoorgsmaal_8 {

    @InterceptorBinding
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Cached {
        /*
        * RetentionPolicy
        * SOURCE - discarded during compilation eks. @Override og @SuppresWarning
        * CLASS - removed during class loading
        * RUNTIME - Only available during runtime eks. interceptors, @Deprecated
         */
    }

    @Cached
    @Interceptor
    public class InterceptorData{
        @AroundInvoke
        public Object cacheMethod(InvocationContext ivC) throws Exception {
            System.out.println("Before Calling Cached Method");
            Object o = ivC.proceed();
            System.out.println("After Calling Cached Method");
            return o;
        }
        @AroundConstruct
        public Object auditConstructor(InvocationContext ivC) throws Exception {
            System.out.println("Before Calling Constructor");
            Object o = ivC.proceed();
            System.out.println("After Calling Constructor");
            return o;
        }
    }

    @Cached
    @Dependent
    public class InterceptedService {
        //Kører Interceptor metode auditConstruction
        public InterceptedService() {
            System.out.println("Kalder Constructor");
        }
        //Kører Interceptor metode cacheMethod
        public void Metode1() {
            System.out.println("Kalder Metode");
        }
    }
}
