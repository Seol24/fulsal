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
import com.dgit.domain.Transfer_reply;
import com.dgit.service.BoardReplyService;
import com.dgit.service.TransferReplyService;

@RestController
@RequestMapping("/replie")
public class TransferReplyController {
	
	
	@Autowired
	private TransferReplyService service;
	
	@RequestMapping(value="/all/{tno}", method=RequestMethod.GET )
	public ResponseEntity<Map<String, Object>> list(@PathVariable("tno") int tno){
		ResponseEntity<Map<String, Object>> entity = null;
		try{
			Map<String, Object> map= new HashMap<>();
			List<Transfer_reply> list = service.list(tno);
			map.put("list", list);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}catch (Exception e) {
			entity  = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody Transfer_reply reply){
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
	@RequestMapping(value="/{trno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("trno") int trno){
		ResponseEntity<String> entity = null;
		
		try{
			Transfer_reply reply = new Transfer_reply();
			reply.setTrno(trno);
			service.delete(trno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	

	@RequestMapping(value="/{trno}", method=RequestMethod.PUT) 
	public ResponseEntity<String> update(@PathVariable("trno") int trno, @RequestBody Transfer_reply reply){
		ResponseEntity<String> entity = null;
		
		try{
			reply.setTrno(trno);
			service.update(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}

