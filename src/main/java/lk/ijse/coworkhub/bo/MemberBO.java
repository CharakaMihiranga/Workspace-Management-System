package lk.ijse.coworkhub.bo;

import lk.ijse.coworkhub.dto.MemberDTO;
import lk.ijse.coworkhub.dto.MessageDTO;

public interface MemberBO extends SuperBO{
    boolean saveMember(MemberDTO memberDTO);
}
