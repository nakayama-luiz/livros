import Book from "@/components/Book";
import Author from "@/components/Author";
import { title } from "@/components/primitives";

export default function BlogPage() {
  return (
    <div>
      <h1 className={title()}>Blog</h1>
      <Author botaoTexto={""} placeholder={""} titulo="" />
      <Book botaoTexto={""} placeholder={""} titulo="" />
    </div>
  );
}
