import { author } from "@/types/author";
import { Image } from "@nextui-org/image";

async function getAuthorData(params: number): Promise<author> {
  const response = await fetch(`http://localhost:8081/api/author/${params}`, {
    cache: "no-cache",
  });

  console.log(response.body);
  return await response.json();
}

export default async function main({
  params,
}: {
  params: { authorId: number };
}) {
  const authorData = await getAuthorData(params.authorId);
  console.log(authorData);
  return (
    <div >
      <div
      // style={{
      //   justifyContent: "center",
      //   alignItems: "center",
      //   display: "flex",
      // }}
      >
        {/* <div className="grid grid-rows-3 grid-flow-col gap-4">
          <div
            style={{
              justifyContent: "center",
              alignItems: "center",
              display: "flex",
            }}
            className="row-span-3"
          >
            <Image isBlurred width={300} src={authorData.picture}></Image>
          </div>

          <div className="col-span-2 ">
            <h1 style={{ fontSize: 30, padding: 10 }}>{authorData.name}</h1>
          </div>
          <div className="row-span-2 col-span-2">
            <p style={{ padding: 10 }}>{authorData.biography}</p>
          </div>
        </div> */}

        <div className="grid grid-rows-3 grid-flow-col gap-4">
          <div className="row-span-3 ...">
            <Image isBlurred width={300} src={authorData.picture}></Image>
            <label htmlFor="">{authorData.vulgos }</label>
          </div>

          <div className="col-span-2 ...">
            <h1 style={{ fontSize: 30 }}>{authorData.name}</h1>
          </div>

          <div className="row-span-2 col-span-2 ...">
            <p style={{}}>{authorData.biography}</p>
          </div>
        </div>
      </div>
    </div>
  );
}
