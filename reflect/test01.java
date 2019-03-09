import java.lang.reflect.*;
import com.pc.aPrivateClass1;
public class test01 {

	public static void main(String[] args) throws Exception {
		
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		Class clazz=loader.loadClass("com.pc.aPrivateClass1");
		aPrivateClass1 pc=(aPrivateClass1)clazz.newInstance();
        Field d=clazz.getDeclaredField("c");
        d.set(pc , 3);
        Method cd=clazz.getDeclaredMethod("d", (Class[])null);
        cd.setAccessible(true);
        cd.invoke(pc,(Object[])null);
	}

}
/*
class aPrivateClass1{
    private int c;
    private void d(){
        System.out.println(c);
    }
}*/