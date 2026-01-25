import { Image } from "@nextui-org/image";
import { Card, CardHeader, CardBody, CardFooter } from "@nextui-org/card";

import { author } from "@/types/author";
import { IAuthorEditionCard } from "@/types/AuthorEditionCard";

async function getAuthorData(params: number): Promise<author> {
  const response = await fetch(`http://localhost:8081/api/author/${params}`,
    { cache: "no-cache", }
  );

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

  return (
    <div>
      <div>
        <div className="flex flex-col gap-6">
          <div className="flex items-start gap-4">
            <Image
              isBlurred
              src={authorData.picture}
              width={300}
              height={300}
              className="rounded-lg"
            />
            <div>
              <h1 className="text-2xl font-bold">{authorData.name}</h1>
              <small className="text-default-500">{authorData.vulgos.join(", ")}</small>
              <div >
                <p>{authorData.biography}</p>
              </div>
            </div>
          </div>
        </div>
        <hr />
        <br />
        <div className="flex flex-col gap-2">
          {authorEditions.map((item, key) => (
            <Card key={key} isPressable shadow="sm">
              <CardBody className="flex flex-row items-center overflow-visible p-2">
                <div className="flex-shrink-0">
                  <Image
                    alt={item.editionTitle}
                    className="w-auto h-[100px] object-cover aspect-auto"
                    radius="lg"
                    shadow="sm"
                    isBlurred
                    src={item.cover}
                  />
                </div>
                <div className="flex flex-col items-start pl-4">
                  <span className="text-sm font-medium">
                    {item.editionTitle}
                  </span>
                  <p className="text-xs text-default-500">
                    Origin year: {item.originYear}
                  </p>
                </div>
              </CardBody>
            </Card>
          ))}
        </div>

      </div>
    </div>
  );
}
