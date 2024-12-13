package org.sist.sist_project.consultationSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsultationScheduleService {

    private final ConsultationScheduleRepository consultationScheduleRepository;

    //페이징 처리 X
    public List<ConsultationSchedule> getAllSchedules() {
        return consultationScheduleRepository.findAll();
    }
    
    // 페이징 처리 + 목록 / 1번 페이지를 주고 싶으면 0을 줘야된다.
 	public Page<ConsultationSchedule> getList(int page) {
 								// pageNumber : 현재 페이지, pageSize : 한 페이지에 몇개
 		// 		Pageable pageable = PageRequest.of(page, 10);
 		
 		List<Sort.Order> sorts = new ArrayList<>();
 		
 		sorts.add(Sort.Order.desc("id"));
 		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
 		return this.consultationScheduleRepository.findAll(pageable);
 	} //
 	
 	// id에 해당하는 상담자 상세정보
 	public ConsultationSchedule getSchedule(Integer id) {
 		Optional<ConsultationSchedule> oCon = this.consultationScheduleRepository.findById(id);
 		return oCon.get();
 	} //
}
