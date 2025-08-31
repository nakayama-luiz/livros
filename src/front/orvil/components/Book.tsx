import React from "react";

interface BookProps {
  titulo: string;
  placeholder: any;
  botaoTexto: any;
}

const Book: React.FC<BookProps> = ({ titulo, placeholder, botaoTexto }) => {
  return (
    <div>
      <h1>{titulo}</h1>
      <input placeholder={placeholder} type="text" />
      <button>{botaoTexto}</button>
    </div>
  );
};

export default Book;
