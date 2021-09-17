import {ApolloClient, ApolloProvider, gql, InMemoryCache, NetworkStatus, useQuery} from "@apollo/client";
import {render} from "react-dom";
import {useState} from "react";

const client = new ApolloClient(
    {
        uri: "http://localhost:8080/graphql",
        cache: new InMemoryCache()
    }
);

const GET_GAMES = gql`
    {
        games {
            id
            name
            imgUrl
        }
    }
`;

function Games({onGameSelected}) {
    const {loading, error, data} = useQuery(GET_GAMES);
    if (loading) return "<p>loading...</p>";
    if (error) return `Error ${error}`;
    return (
        <select name="game" onChange={onGameSelected}>
            {data.games.map(game => (
                <option key={game.id} value={game.id}>
                    {game.name}
                </option>
            ))}
        </select>
    );
}

const GET_GAME_BY_ID = gql`
    query getGameById($gameId: String!){
        queryGameById(id: $gameId) {
            id
            imgUrl
        }
    }
`;

function GamePhoto({gameId}) {
    const {loading, error, data, refetch, networkStatus} = useQuery(GET_GAME_BY_ID,
        {
            variables: {gameId},
            notifyOnNetworkStatusChange: true
        });
    if (networkStatus === NetworkStatus.refetch) return 'refetch...';
    if (loading) return 'loading..';
    if (error) return `${error}`;
    return (
        <div>
            <img src={data.queryGameById.imgUrl} style={{width: '10%', height: '10%'}}/>
            <button onClick={()=>refetch()}>Refetch</button>
        </div>
    );
}

function App() {
    const [selectGame, setSelectGame] = useState(null);

    function onGameSelected({target}) {
        console.log(target.value);
        setSelectGame(target.value);
    }

    return (
        <ApolloProvider client={client}>
            <div>
                <h2>Select</h2>
                <Games onGameSelected={onGameSelected}/>
                {selectGame && <GamePhoto gameId={selectGame} />}
            </div>
        </ApolloProvider>
    );
}

render(<App/>, document.getElementById("root"));