import React from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { Button, Input, Table, Grid } from 'semantic-ui-react';
import * as Yup from 'yup';
import clienteService from '../service/ClienteService';

const validationSchema = Yup.object().shape({
  nome: Yup.string()
    .required('O nome é obrigatório')
    .min(10, 'O nome deve ter no mínimo 10 caracteres'),
  telefones: Yup.array().of(
    Yup.object().shape({
      numero: Yup.string().required('O número do telefone é obrigatório')
    })
  )
});

const ClienteForm = () => {
  const initialValues = {
    nome: '',
    endereco: {
      rua: '',
      cidade: '',
      bairro: '',
      numero: ''
    },
    telefones: [{ numero: '' }]
  };

  const handleSubmit = async (values, { setSubmitting, resetForm }) => {
  try {
    await clienteService.createCliente(values);
    alert('Cliente cadastrado com sucesso!');
    resetForm();
  } catch (error) {
    if (error.message) {
      alert(`Erro: ${error.message}`);
    } else {
      alert('Erro ao cadastrar cliente. Tente novamente.');
    }
  } finally {
    setSubmitting(false);
  }
};



  return (
    <Formik
      initialValues={initialValues}
      validationSchema={validationSchema}
      onSubmit={handleSubmit}
    >
      {({ values, isSubmitting, setFieldValue }) => (
        <Form>
          <Grid>
            <Field name="nome" as={Input} placeholder="Nome" style={{ width: '60%' }}/>
            <ErrorMessage name="nome" component="div" />
          </Grid>
          <Grid>
            <Grid.Row columns={2}>
              <Grid.Column>
                <Field name="endereco.rua" as={Input} placeholder="Rua" style={{ width: '100%' }} />
                <ErrorMessage name="endereco.rua" component="div" />
              </Grid.Column>
              <Grid.Column>
                <Field name="endereco.cidade" as={Input} placeholder="Cidade" style={{ width: '70%' }}/>
                <ErrorMessage name="endereco.cidade" component="div" />
              </Grid.Column>
            </Grid.Row>
            <Grid.Row columns={2}>
              <Grid.Column>
                <Field name="endereco.bairro" as={Input} placeholder="Bairro" style={{ width: '100%' }}/>
                <ErrorMessage name="endereco.bairro" component="div" />
              </Grid.Column>
              <Grid.Column>
                <Field name="endereco.numero" as={Input} placeholder="Número" style={{ width: '70%' }}/>
                <ErrorMessage name="endereco.numero" component="div" />
              </Grid.Column>
            </Grid.Row>
          </Grid>

          <Table celled>
            <Table.Header>
              <Table.Row>
                <Table.HeaderCell>Telefones</Table.HeaderCell>
                <Table.HeaderCell>Ações</Table.HeaderCell>
              </Table.Row>
            </Table.Header>
            <Table.Body>
              {values.telefones.map((telefone, index) => (
                <Table.Row key={index}>
                  <Table.Cell>
                    <Field
                      name={`telefones[${index}].numero`}
                      as={Input}
                      placeholder="Número do telefone"
                    />
                    <ErrorMessage name={`telefones[${index}].numero`} component="div" />
                  </Table.Cell>
                  <Table.Cell>
                    <Button
                      type="button"
                      onClick={() => {
                        const telefonesAtualizados = values.telefones.filter((_, i) => i !== index);
                        setFieldValue('telefones', telefonesAtualizados);
                      }}
                    >
                      Remover
                    </Button>
                  </Table.Cell>
                </Table.Row>
              ))}
              <Table.Row>
                <Table.Cell colSpan="2">
                  <Button
                    type="button"
                    onClick={() => setFieldValue('telefones', values.telefones.concat({ numero: '' }))}
                  >
                    Adicionar Telefone
                  </Button>
                </Table.Cell>
              </Table.Row>
            </Table.Body>
          </Table>

          <Button type="submit" disabled={isSubmitting}>
            Salvar
          </Button>
        </Form>
      )}
    </Formik>
  );
};

export default ClienteForm;
