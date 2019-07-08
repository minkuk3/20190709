package kr.co.te;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	public static BoardDAO dao;
	public BoardDAO(){}
	
	public static BoardDAO getInstance() {
		
		if(dao == null){
			dao = new BoardDAO();		
		}
				
		return dao;
		
	}
	
	public List<CarVO> getList(){
		
		List<CarVO> list = new ArrayList<CarVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT"
					+ " C_NO, C_NAME, to_char(C_REGDATE, 'YYYY-MM-DD') as C_REGDATE, C_PRICE "
					+ " FROM CAR_INFO ";
			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()){
				CarVO vo = new CarVO();
				vo.setC_no(rs.getInt("c_no"));
				vo.setC_name(rs.getString("c_name"));
				vo.setC_regdate(rs.getString("c_regdate"));
				vo.setC_price(rs.getInt("c_price"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, rs);
		}
		
		return list;
		
	}
	
	

}
