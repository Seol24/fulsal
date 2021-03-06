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
import com.dgit.service.BoardReplyService;

@RestController
@RequestMapping("/replies")
public class BoardReplyController {
	
	
	@Autowired
	BoardReplyService service;
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET )
	public ResponseEntity<Map<String, Object>> list(@PathVariable("bno") int bno){
		ResponseEntity<Map<String, Object>> entity = null;
		try{
			Map<String, Object> map= new HashMap<>();
			List<Board_reply> list = service.list(bno);
			map.put("list", list);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}catch (Exception e) {
			entity  = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody Board_reply reply){
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
	@RequestMapping(value="/{brno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("brno") int brno){
		ResponseEntity<String> entity = null;
		
		try{
			Board_reply reply = new Board_reply();
			reply.setBrno(brno);
			service.delete(brno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/{brno}", method=RequestMethod.PUT) 
	public ResponseEntity<String> update(@PathVariable("brno") int brno, @RequestBody Board_reply reply){
		System.out.println("aaaaaa");
		ResponseEntity<String> entity = null;
		try{
			reply.setBrno(brno);
			System.out.println("brno = "+ brno);
			service.update(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}

