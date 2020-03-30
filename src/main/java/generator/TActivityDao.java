package generator;

import generator.TActivity;
import generator.TActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TActivityDao {
    long countByExample(TActivityExample example);

    int deleteByExample(TActivityExample example);

    int deleteByPrimaryKey(String id);

    int insert(TActivity record);

    int insertSelective(TActivity record);

    List<TActivity> selectByExampleWithBLOBs(TActivityExample example);

    List<TActivity> selectByExample(TActivityExample example);

    TActivity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByExample(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByPrimaryKeySelective(TActivity record);

    int updateByPrimaryKeyWithBLOBs(TActivity record);

    int updateByPrimaryKey(TActivity record);
}