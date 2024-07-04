import { useState } from "react";

const useInput = (initForm) => {
  const [form, setForm] = useState(initForm);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((form) => ({ ...form, [name]: value }));
  };

  const handleReset = () => {
    setForm(initForm);
  };

  return { form, handleChange, handleReset };
};

export default useInput;
