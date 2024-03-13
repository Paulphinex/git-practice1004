package org.zerock.mapper;

import io.micrometer.common.util.internal.logging.InternalLogger;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.config.DBConfig;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {
    private Long[] bnoArr ={3145745L,3145744L,3145743L,3145742L,3145741L};
    @Setter(onMethod_ =@Autowired)
    private ReplyMapper mapper;
    private InternalLogger log;

    @Test
    public void testcreate(){
        IntStream.rangeClosed(1,10).forEach(i ->{
            ReplyVO vo = new ReplyVO();
            //게시물의번호
            vo.setBno(bnoArr[i%5]);
            vo.setReply("댓글 테스트"+ i);
            vo.setReplyer("replyer"+ i);
            mapper.insert(vo);
        });
    }
    @Test
    public void testMapper(){
        log.info(mapper);
    }
    @Test
    public void testRead(){
        Long targetRno =5L;
        ReplyVO vo = mapper.read(targetRno);
        log.info(vo);
    }
    @Test
    public void testDelete(){
        Long targetRno =1L;
        mapper.delete(targetRno);
    }
    @Test
    public void testUpdate(){
        Long targetRno =10L;
        ReplyVO vo= mapper.read(targetRno);
        vo.setReply("Update Reply ");
        int count = mapper.update(vo);
        log.info("UPDATE COUNT: " + count);
    }
    @Test
    public void testList(){
        Criteria cri =new Criteria();
        List<ReplyVO>replies =mapper.getListWithPaging(cri, bnoArr[0]);
        replies.forEach(reply ->log.info(reply));
    }
}
