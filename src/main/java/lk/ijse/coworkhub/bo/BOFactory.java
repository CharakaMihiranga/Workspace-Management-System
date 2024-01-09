package lk.ijse.coworkhub.bo;

import lk.ijse.coworkhub.bo.Impl.MemberBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory =
                new BOFactory() : boFactory;
    }
    public enum BOTypes{
        MEMBER
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case MEMBER :
                return new MemberBOImpl();
            default:
                return null;
        }
    }
}
