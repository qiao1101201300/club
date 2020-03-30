package generator;

import generator.TClub;
import generator.TClubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TClubDao {
    long countByExample(TClubExample example);

    int deleteByExample(TClubExample example);

    int deleteByPrimaryKey(String id);

    int insert(TClub record);

    int insertSelective(TClub record);

    List<TClub> selectByExampleWithBLOBs(TClubExample example);

    List<TClub> selectByExample(TClubExample example);

    TClub selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TClub record, @Param("example") TClubExample example);

    int updateByExampleWithBLOBs(@Param("record") TClub record, @Param("example") TClubExample example);

    int updateByExample(@Param("record") TClub record, @Param("example") TClubExample example);

    int updateByPrimaryKeySelective(TClub record);

    int updateByPrimaryKeyWithBLOBs(TClub record);

    int updateByPrimaryKey(TClub record);
}