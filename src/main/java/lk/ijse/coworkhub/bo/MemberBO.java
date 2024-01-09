package lk.ijse.coworkhub.bo;

import lk.ijse.coworkhub.dto.MemberDTO;
import lk.ijse.coworkhub.dto.MessageDTO;

import java.sql.SQLException;

public interface MemberBO extends SuperBO{
    boolean saveMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException;
}
