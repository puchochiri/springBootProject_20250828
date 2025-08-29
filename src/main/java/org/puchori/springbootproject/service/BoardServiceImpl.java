package org.puchori.springbootproject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.puchori.springbootproject.domain.Board;
import org.puchori.springbootproject.dto.BoardDTO;
import org.puchori.springbootproject.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

  private final ModelMapper modelMapper;

  private final BoardRepository boardRepository;

  @Override
  public Long register(BoardDTO boardDTO) {

    Board board = modelMapper.map(boardDTO, Board.class);

    Long bno = boardRepository.save(board).getBno();

    return bno;

  }
}
