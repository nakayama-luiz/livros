import { Image } from "@nextui-org/image";
import { Card, CardHeader, CardBody, CardFooter } from "@nextui-org/card";

import { author } from "@/types/author";
import { IAuthorEditionCard } from "@/types/AuthorEditionCard";

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
      <div>
        <div className="grid grid-rows-3 grid-flow-col gap-4">
          <div className="row-span-3 ...">
            <Image isBlurred src={authorData.picture} width={300} />
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
          {authorEditions.map((item, key) => (
            <Card key={key} isPressable shadow="sm">
              <CardBody className="flex flex-row items-center overflow-visible p-0 px-2 py-1">
                <div className="flex flex-col items-start">
                  <Image
                    alt={item.editiontitle}
                    className="w-auto h-[200px] object-cover aspect-auto"
                    radius="lg"
                    shadow="sm"
                    src={item.cover}
                  />
                </div>
                <div className="flex flex-col items-start pl-4">
                  <span className="text-sm font-medium">
                    {item.publishername}
                  </span>
                </div>
              </CardBody>
              <CardFooter className="justify-center items-center flex">
                <h1 className="text-xs text-center">{item.editiontitle}</h1>
              </CardFooter>
            </Card>
          ))}
        </div>
      </div>
    </div>
  );
}
