import React from 'react';
import { Field } from 'formik';
import { Table, Input } from 'semantic-ui-react';

const TelefoneList = ({ telefones, arrayHelpers }) => (
  <>
    {telefones.map((telefone, index) => (
      <Table.Row key={index}>
        <Table.Cell>
          <Field
            name={`telefones[${index}].numero`}
            as={Input}
            placeholder="Número do telefone"
          />
        </Table.Cell>
      </Table.Row>
    ))}
  </>
);

export default TelefoneList;
