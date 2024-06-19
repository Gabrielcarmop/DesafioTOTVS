import React from 'react';
import ClienteForm from './components/ClienteForm';
import './App.css';
import 'semantic-ui-css/semantic.min.css';

function App() {
  return (
    <div className="app">
      <header className="app-header">
        <h1>Cadastro de Clientes</h1>
      </header>
      <main className="app-content">
        <ClienteForm />
      </main>
    </div>
  );
}

export default App;
