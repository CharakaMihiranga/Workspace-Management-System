package lk.ijse.coworkhub.dao.custom.impl;

import lk.ijse.coworkhub.dao.custom.MemberDAO;
import lk.ijse.coworkhub.dto.MemberDTO;

import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public ArrayList<MemberDTO> getAll() {
        return null;
    }

    @Override
    public boolean save(MemberDTO dto) {
        return false;
    }

    @Override
    public boolean update(MemberDTO dto) {
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
    public MemberDTO search(String id) {
        return null;
    }
}
