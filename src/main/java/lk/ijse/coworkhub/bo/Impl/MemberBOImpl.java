package lk.ijse.coworkhub.bo.Impl;

import lk.ijse.coworkhub.bo.MemberBO;
import lk.ijse.coworkhub.dao.DAOFactory;
import lk.ijse.coworkhub.dao.custom.MemberDAO;
import lk.ijse.coworkhub.dto.MemberDTO;
import lk.ijse.coworkhub.entity.Member;

import java.sql.SQLException;

public class MemberBOImpl implements MemberBO {

    MemberDAO memberDAO =
            (MemberDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MEMBER);

    @Override
    public boolean saveMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        return memberDAO.save(new Member(
                memberDTO.getId(),
                memberDTO.getFirstName(),
                memberDTO.getLastName(),
                memberDTO.getEmail(),
                memberDTO.getAddress(),
                memberDTO.getDob(),
                memberDTO.getAge(),
                memberDTO.getProfession(),
                memberDTO.getLoyalty(),
                memberDTO.getPhone(),
                memberDTO.getEmergencyContact(),
                memberDTO.getMemberPicPath()
                ));
    }
}
