package lk.ijse.coworkhub.dao;

import lk.ijse.coworkhub.dao.custom.impl.MemberDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    public static  DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory =
                new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        MEMBER
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case MEMBER :
                return new MemberDAOImpl();
            default :
                return null;
        }
    }
}
