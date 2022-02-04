package com.order.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.order.domain.dto.request.OrderRequestDto;
import com.order.domain.dto.response.OrderResponseDto;

import com.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Api("orders")
@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {

	@Autowired
	private OrderService service;

	@ApiOperation(value = "Buscar um pedido pelo ID", notes = "Este endpoint busca um pedido pelo id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Pedido encontrado com sucesso"),
			@ApiResponse(code = 404, message = "Pedido não encontrado"),
			@ApiResponse(code = 401, message = "O cliente deve está autenticado ao sistema"),
			@ApiResponse(code = 500, message = "Erro interno do servidor") })
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDto> getByOrder(@PathVariable Long id) {
		log.info("The order return");
		return ResponseEntity.ok().body(service.getByOrder(id));
	}

	@ApiOperation(value = "Retorna uma lista de pedido", notes = "Este endpoint retorna uma lista de pedido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requisição feita com sucesso"),
			@ApiResponse(code = 403, message = "Cliente não autorizado"),
			@ApiResponse(code = 401, message = "O cliente deve está autenticado no sistema"),
			@ApiResponse(code = 500, message = "Erro interno do servidor") })
	@GetMapping()
	public ResponseEntity<Page<OrderResponseDto>> getByDescription(
			@PageableDefault(direction = Direction.ASC, page = 0, size = 5) Pageable pageable) {
		log.info("Orders will be listed in pageable form");
		return ResponseEntity.ok().body(service.findByDescription(pageable));
	}

	@ApiOperation(value = "Salvar Pedido", notes = "Este endpoint salvar um pedido ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Pedido cadastrado com sucesso"),
			@ApiResponse(code = 401, message = "O cliente deve está autenticado ao sistema"),
			@ApiResponse(code = 403, message = "Cliente não autorizado"),
			@ApiResponse(code = 500, message = "Erro interno do servidor") })
	@PostMapping()
	public ResponseEntity<OrderResponseDto> save(@Valid @RequestBody OrderRequestDto orderRequestDto) {
		OrderResponseDto save = service.save(orderRequestDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
		log.info("The order saved");
		return ResponseEntity.created(uri).body(save);
	}

	@ApiOperation(value = "Exclui um pedido", notes = "Este endpoint exclui um pedido")
	@ApiResponses({ @ApiResponse(code = 204, message = "Pedido excluido com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno do servidor") })
	@DeleteMapping("/{id}")
	public ResponseEntity<OrderResponseDto> delete(@PathVariable Long id) {
		service.delete(id);
		log.info("The  order deleted");
		return ResponseEntity.noContent().build();
	}
}
