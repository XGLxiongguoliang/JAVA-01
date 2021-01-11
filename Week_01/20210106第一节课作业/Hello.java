package jikeshijian.jvm;

/**
 * @program jikeshijian.jvm
 * @description bytecode
 * @auther Mr.Xiong
 * @create 2021-01-09 13:57
 */
public class Hello {

    public static void main(String[] args) {
        int ia = 32768;
        int ib = 32768;
        int ijia = ia + ib;
        int ijian = ia - ib;
        int ichen = ia*ib;
        int ichu = ia/ib;

        long la = 2l;
        long lb =3l;
        long ljia = la + lb;
        long ljian = la - lb;
        long lchen = la*lb;
        long lchu = la/lb;

        float fa = 2f;
        float fb =3f;
        float fjia = fa + fb;
        float fjian = fa - fb;
        float fchen = fa*fb;
        float fchu = fa/fb;

        double da = 2d;
        double db =3d;
        double djia = da + db;
        double djian = da - db;
        double dchen = da*db;
        double dchu = da/db;

        for (int i = 0; i < ib ; i++) {
            System.out.println("bytecode learn");
        }

        if (ia < ib) {
            System.out.println("ia < ib ");
        } else {
            System.out.println("ia > ib");
        }
    }


}
