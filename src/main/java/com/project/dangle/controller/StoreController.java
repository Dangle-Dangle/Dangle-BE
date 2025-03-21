package com.project.dangle.controller;

import com.project.dangle.command.DesignerVO;
import com.project.dangle.command.GroomingVO;
import com.project.dangle.command.ReviewVO;
import com.project.dangle.command.StoreVO;
import com.project.dangle.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 매장조회
    @GetMapping("/getStoreList")
    public List<StoreVO> getStoreList() {
        List<StoreVO> list = storeService.getStoreList();
        System.out.println("매장 리스트: " + list);
        return list;
    }

    // 디자이너조회
    @GetMapping("/getDesignerListByStoreNo")
    public List<DesignerVO> getDesignerListByStoreNo(@RequestParam Integer storeNo) {
        List<DesignerVO> list = storeService.getDesignerListByStoreNo(storeNo);
        return list;
    }

    // 미용메뉴조회
    @GetMapping("/getGroomingListByStoreNo")
    public List<GroomingVO> getGroomingListByStoreNo(@RequestParam Integer storeNo) {
        List<GroomingVO> list = storeService.getGroomingListByStoreNo(storeNo);
        return list;
    }

    // 리뷰조회
    @GetMapping("/getReviewListByStoreNo")
    public List<ReviewVO> getReviewListByStoreNo(@RequestParam Integer storeNo) {
        List<ReviewVO> list = storeService.getReviewListByStoreNo(storeNo);
        return list;
    }
}
