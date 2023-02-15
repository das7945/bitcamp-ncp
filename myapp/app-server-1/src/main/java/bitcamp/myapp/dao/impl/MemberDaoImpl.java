package bitcamp.myapp.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ConnectionFactory;

public class MemberDaoImpl implements MemberDao {

  ConnectionFactory conFactory;
  SqlSessionFactory sqlSessionFactory;

  public MemberDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Member m) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      sqlSession.insert("MemberMapper.insert", m);
      sqlSession.commit();
    }
  }

  @Override
  public List<Member> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("MemberMapper.findAll");
    }
  }

  @Override
  public Member findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("MemberMapper.findByNo", no);
    }
  }

  @Override
  public int update(Member m) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("MemberMapper.update", m);
    }
  }

  @Override
  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("MemberMapper.delete", no);
    }
  }
}























