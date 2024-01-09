package lk.ijse.coworkhub.bo.Impl;

import lk.ijse.coworkhub.bo.MemberBO;
import lk.ijse.coworkhub.dao.DAOFactory;
import lk.ijse.coworkhub.dao.custom.MemberDAO;
import lk.ijse.coworkhub.dto.MemberDTO;

public class MemberBOImpl implements MemberBO {

    MemberDAO memberDAO ;

    @Override
    public boolean saveMember(MemberDTO messageDTO) {
        return false;
    }
}
