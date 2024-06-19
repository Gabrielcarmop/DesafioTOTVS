const clienteService = {
    createCliente: async (clienteData) => {
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(clienteData)
      };
  
      const response = await fetch('http://localhost:8080/api/clientes', requestOptions);
      if (!response.ok) {
        const errorBody = await response.json();
        throw new Error(errorBody.message || 'Erro desconhecido ao criar cliente');
      }
      return await response.json();
    },
  };
  
  export default clienteService;
  