# API-Enderecos 
Sistema de localização e cadastro de endereços a partir de um CEP

*GET /enderecos* 
Retorna todos os endereços cadastrados

*GET /endereco/{cep}* 
Retorna o endereço correspondente ao cep

*POST /endereco*   
Adiciona endereço e retorna mensagem de sucesso

*DELETE /endereco/{cep}*
Deleta endereço pelo cep e retorna mensagem de sucesso ao deletar


 As mensagens de erro seguem este padrão:
{
"status": "erro",   
"mensagem": "Mensagem de Erro" 
} 
