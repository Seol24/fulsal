package com.dgit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.Board_reply;
import com.dgit.domain.MatchingReply;
import com.dgit.service.BoardReplyService;
import com.dgit.service.MatchingReplyService;

@RestController
@RequestMapping("/repliess")
public class MatchingReplyController {
	
	
	@Autowired
	private MatchingReplyService service;
	
	@RequestMapping(value="/all/{rno}", method=RequestMethod.GET )
	public ResponseEntity<Map<String, Object>> list(@PathVariable("rno") int rno){
		ResponseEntity<Map<String, Object>> entity = null;
		try{
			Map<String, Object> map= new HashMap<>();
			List<MatchingReply> list = service.list(rno);
			map.put("list", list);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}catch (Exception e) {
			entity  = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody MatchingReply reply){
		System.out.println("--ADD--");
		System.out.println(reply);
		ResponseEntity<String> entity = null;
		try {
			service.create(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/{mrno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("mrno") int mrno){
		ResponseEntity<String> entity = null;
		
		try{
			MatchingReply reply = new MatchingReply();
			reply.setMrno(mrno);
			service.delete(mrno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/{mrno}", method=RequestMethod.PUT) 
	public ResponseEntity<String> update(@PathVariable("mrno") int mrno, @RequestBody MatchingReply reply){
		System.out.println("aaaaaa");
		ResponseEntity<String> entity = null;
		try{
			reply.setMrno(mrno);
			System.out.println("mrno = "+ mrno);
			service.update(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}

