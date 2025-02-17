import { Button, Form } from "react-bootstrap";
import { useForm } from "react-hook-form";

function MilkTheCowsForm( {submitAction} ) {

    // Stryker disable all
    const {
      handleSubmit,
    } = useForm(
    );
    // Stryker restore all

    return (
      <Form onSubmit={handleSubmit(submitAction)}>
        <p>Click this button to milk the cows across all commons!</p>
        <Button type="submit" data-testid="MilkTheCowsForm-Submit-Button">Milk!</Button>
    </Form>
    );
  }
  
  export default MilkTheCowsForm;
  
