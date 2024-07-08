import { author } from "@/types/author";
import { IAuthorEditionCard } from "@/types/AuthorEditionCard";
import { Image } from "@nextui-org/image";
import { Card, CardHeader, CardBody, CardFooter } from "@nextui-org/card";
import { wrap } from "module";

async function getAuthorData(params: number): Promise<author> {
  const response = await fetch(`http://localhost:8081/api/author/${params}`, {
    cache: "no-cache",
  });

  console.log(response.body);
  return await response.json();
}

async function getAuthorEditions(
  params: number
): Promise<IAuthorEditionCard[]> {
  const response = await fetch(
    `http://localhost:8081/api/edition/author/${params}`,
    { cache: "no-cache" }
  );
  console.log(response.body);
  return await response.json();
}

export default async function main({
  params,
}: {
  params: { authorId: number };
}) {
  const authorData = await getAuthorData(params.authorId);
  const authorEditions = await getAuthorEditions(params.authorId);
  console.log(authorData);
  console.log(authorEditions);
  return (
    <div>
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
            {/* <label htmlFor="">{authorData.vulgos}</label> */}
          </div>

          <div className="col-span-2 ...">
            <h1 style={{ fontSize: 30 }}>{authorData.name}</h1>
            <small className="text-default-500">{authorData.vulgos}</small>
          </div>

          <div className="row-span-2 col-span-2 ...">
            <p style={{}}>{authorData.biography}</p>
          </div>
        </div>
        <hr />
        <br />
        <div className="gap-2 grid grid-cols-2 sm:grid-cols-4">
  {authorEditions.map((item, index) => (
    <Card shadow="sm" key={index} isPressable>
      <CardBody className="flex flex-col justify-center items-center overflow-visible p-0 px-2 py-1">
        <Image
          shadow="sm"
          radius="lg"
          alt={item.editiontitle}
          className="w-auto h-[200px] object-cover aspect-auto"
          src={item.cover}
        />
      </CardBody>
      <CardFooter className="justify-center items-center flex">

        <h1 className="text-xs text-center">{item.editiontitle}</h1>
      </CardFooter>
    </Card>
  ))}
</div>
        {/* <div>
          {authorEditions.map((ele) => (
            <div>
              <Card className="py-4">
                <CardHeader className="pb-0 pt-2 px-4 flex-col items-start">
                  <p className="text-tiny uppercase font-bold">Daily Mix</p>
                  <small className="text-default-500">{ele.authorname}</small>
                  <h4 className="font-bold text-large">{ele.editiontitle}</h4>
                </CardHeader>
                <CardBody className="overflow-visible py-2">
                  <Image
                    alt="Card background"
                    className="object-cover rounded-xl"
                    src={ele.cover}
                    width={100}
                  />
                </CardBody>
              </Card>
            </div>
          ))}
        </div> */}

        <div
          className="cards-container"
          style={{
            display: "flex",
            flexWrap: "wrap",
            gap: 10,
            justifyContent: "center",
          }}
        >
          {authorEditions.map((ele) => (
            <div
              className="card-wrapper"
              style={{
                display: "inline-block",
                flex: 1,
                maxWidth: 250,
                margin: 10,
              }}
            >
              <Card className="py-4 card-content">
                <CardHeader className="pb-0 pt-2 px-4 flex-col items-center justify-center flex">
                  {/* <p className="text-tiny uppercase font-bold">Daily Mix</p> */}
                  {/* <small className="text-default-500">{ele.authorname}</small> */}
                  <h4 className="font-bold text-large">{ele.editiontitle}</h4>
                </CardHeader>
                <CardBody className="overflow-visible py-2">
                  <div
                    style={{
                      justifyContent: "center",
                      display: "flex",
                      alignItems: "center",
                    }}
                  >
                    <Image
                      alt="Card background"
                      className="object-cover rounded-xl"
                      src={ele.cover}
                      width={100}
                    />
                  </div>
                </CardBody>
              </Card>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
