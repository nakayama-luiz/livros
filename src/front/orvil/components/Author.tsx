"use client";

import React, { useState, useEffect } from "react";

interface AuthorProps {
  titulo: string;
  placeholder: any;
  botaoTexto: any;
}

const Author: React.FC<AuthorProps> = ({ titulo, placeholder, botaoTexto }) => {
  const [data, setData] = useState<any[]>([]);
  const [form, setForm] = useState<Partial<AuthorProps>>({
    titulo: "",
    placeholder: null,
    botaoTexto: null,
  });

  const apiUrl = "";

  useEffect(() => {
    fetch(apiUrl)
      .then((response) => response.json())
      .then((data) => setData(data))
      .catch((error) => console.error("Erro ao buscar dados:", error));
  }, [apiUrl]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({
      ...form,
      [e.target.name]:
        e.target.type === "checkbox" ? e.target.checked : e.target.value,
    });
  };

  const handleCreate = () => {
    fetch(apiUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form),
    })
      .then((response) => response.json())
      .then((newItem) => setData([...data, newItem]))
      .catch((error) => console.error("Erro ao criar item:", error));
  };

  const handleUpdate = (id: number) => {
    fetch(`${apiUrl}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form),
    })
      .then((response) => response.json())
      .then((updatedItem) => {
        setData(data.map((item) => (item.id === id ? updatedItem : item)));
      })
      .catch((error) => console.error("Erro ao atualizar item:", error));
  };

  const handleDelete = (id: number) => {
    fetch(`${apiUrl}/${id}`, {
      method: "DELETE",
    })
      .then(() => {
        setData(data.filter((item) => item.id !== id));
      })
      .catch((error) => console.error("Erro ao excluir item:", error));
  };

  return (
    <div>
      <h1>{titulo}</h1>
      <input
        name="titulo"
        placeholder="Titulo"
        type="text"
        value={form.titulo || ""}
        onChange={handleChange}
      />

      <button type="button" onClick={handleCreate}>
        Criar
      </button>
      <div>
        {data.map((item) => (
          <div key={item.id}>
            <span>{item.nome}</span>
            <button type="button" onClick={() => handleUpdate(item.id)}>
              Atualizar
            </button>
            <button type="button" onClick={() => handleDelete(item.id)}>
              Excluir
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Author;
