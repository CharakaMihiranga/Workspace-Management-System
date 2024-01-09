package lk.ijse.coworkhub.dao.custom.impl;

import lk.ijse.coworkhub.dao.SQLUtil;
import lk.ijse.coworkhub.dao.custom.MemberDAO;
import lk.ijse.coworkhub.dto.MemberDTO;
import lk.ijse.coworkhub.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {

    @Override
    public ArrayList<Member> getAll() {
        return null;
    }

    @Override
    public boolean save(Member dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO member VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getAddress(),
                dto.getDob(),
                dto.getAge(),
                dto.getProfession(),
                dto.getLoyalty(),
                dto.getPhone(),
                dto.getEmergencyContact(),
                dto.getMemberPicPath()
        );
    }

    @Override
    public boolean update(Member dto) {
        return false;
    }

    @Override
    public boolean exist(String id) {
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public String generateID() {
        return null;
    }

    @Override
    public Member search(String id) {
        return null;
    }
}
