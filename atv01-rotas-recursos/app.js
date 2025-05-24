const express = require('express');
const req = require('express/lib/request');
const res = require('express/lib/response');
const port = process.env.PORT || 3000;
const app = express();
app.use(express.json());

/* CRIACAO DOS ARRAYS QUE ARMAZENAM OS RECURSOS DA API */
// Livros
const livros = [
  {id: 1, titulo: 'Dom Casmurro', autor: 'Machado de Assis', anoPublicacao: 1899, numeroPaginas: 346},
  {id: 2, titulo: 'A Revolução dos Bichos', autor: 'George Orwell', anoPublicacao: 1945, numeroPaginas: 152},
  {id: 3, titulo: 'O Hobbit', autor: 'J.R.R. Tolkien', anoPublicacao: 1937, numeroPaginas: 328},
  {id: 4, titulo: 'Lolita', autor: 'Vladimir Nabokov', anoPublicacao: 1955, numeroPaginas: 336},
  {id: 5, titulo: 'American Psycho', autor: 'Bret Easton Ellis', anoPublicacao: 1991, numeroPaginas: 399}
];

// Usuarios
const usuarios = [
    {id: 1, nome: 'João Almeida da Silva', email: 'joaozinho@exemplo.com', dataInscricao: '2025-03-27'},
    {id: 2, nome: 'Gabriel Cardoso', email: 'gabriel@exemplo.com', dataInscricao: '2025-05-07'},
    {id: 3, nome: 'José Alves da Costa', email: 'jose@icloud.com', dataInscricao: '2023-04-02'},
    {id: 4, nome: 'Dalva de Oliveira Soares', email: 'dalva@outlook.com', dataInscricao: '2024-12-10'},
    {id: 5, nome: 'Carlos Pinheiro de Souza', email: 'carlinhos@gmail.com', dataInscricao: '2023-09-13'}
]

// Rota padrao (raiz)
app.get('/', (req, res) => {
    res.send('Hello World!');
});

/* IMPLEMENTANDO O CRUD PARA LIVROS */
// READ: retornar todos os livros | HTTP GET
app.get('/livros', (req, res) => {
    res.status(200).json(livros);
});

// READ: retornar um livro especifico | HTTP GET
app.get('/livros/:id', (req, res) => {
    const {id} = req.params;
    const livro = livros.find(l => l.id === parseInt(id));

    if (!livro) {
        res.status(404).json({mensagem: 'Livro não encontrado.'});
        return;
    }

    res.status(200).json(livro);
});

// CREATE: salvar um novo livro | HTTP POST
app.post('/livros', (req, res) => {
    const {titulo, autor, anoPublicacao, numeroPaginas} = req.body;

    if (!titulo || !autor || !anoPublicacao || !numeroPaginas) {
        return res.status(400).json({mensagem: 'Falha ao salvar novo livro. Os campos título, autor, ano de publicação e quantidade de páginas são obrigatórios.'});
    }

    const novoLivro = {
        id: livros.length + 1,
        titulo,
        autor, 
        anoPublicacao,
        numeroPaginas
    };

    livros.push(novoLivro);
    res.status(201).json(novoLivro);
});

// UPDATE: modificar dados de um livro especifico | HTTP PUT
app.put('/livros/:id', (req, res) => {
    const {id} = req.params;
    const {titulo, autor, anoPublicacao, numeroPaginas} = req.body;

    const livro = livros.find(l => l.id === parseInt(id));

    if (!livro) {
        return res.status(404).json({mensagem: 'Livro não encontrado.'});
    }

    livro.titulo = titulo || livro.titulo;
    livro.autor = autor || livro.autor;
    livro.anoPublicacao = anoPublicacao || livro.anoPublicacao;
    livro.numeroPaginas = numeroPaginas || livro.numeroPaginas;

    res.status(200).json(livro);
});

// DELETE: excluir um livro especifico | HTTP DELETE
app.delete('/livros/:id', (req, res) => {
    const {id} = req.params;

    const indice = livros.findIndex(l => l.id === parseInt(id));

    if (indice === -1) {
        return res.status(404).json({mensagem: 'Livro não encontrado.'});
    }

    livros.splice(indice, 1);

    res.status(204).send();
});

/* IMPLEMENTANDO O CRUD PARA USUARIOS */
// READ: retornar todos os usuarios | HTTP GET
app.get('/usuarios', (req, res) => {
    res.status(200).json(usuarios);
});

// READ: retornar um usuario especifico | HTTP GET
app.get('/usuarios/:id', (req, res) => {
    const {id} = req.params;
    const usuario = usuarios.find(u => u.id === parseInt(id));

    if (!usuario) {
        res.status(404).json({mensagem: 'Usuário não encontrado.'});
        return;
    }

    res.status(200).json(usuario);
});

// CREATE: salvar um novo usuario | HTTP POST
app.post('/usuarios', (req, res) => {
    const {nome, email, dataInscricao} = req.body;

    if (!nome || !email || !dataInscricao) {
        return res.status(400).json({mensagem: 'Falha ao criar novo usuário. Os campos de nome, e-mail e data da inscrição são obrigatórios.'});
    }

    const novoUsuario = {
        id: usuarios.length + 1,
        nome,
        email,
        dataInscricao
    }

    usuarios.push(novoUsuario);
    res.status(201).json(novoUsuario);
});

// UPDATE: modificar dados de um usuario especifico | HTTP PUT
app.put('/usuarios/:id', (req, res) => {
    const {id} = req.params;
    const {nome, email, dataInscricao} = req.body;

    const usuario = usuarios.find(u => u.id === parseInt(id));

    if (!usuario) {
        return res.status(404).json({mensagem: 'Usuário não encontrado.'});
    }

    usuario.nome = nome || usuario.nome;
    usuario.email = email || usuario.email;
    usuario.dataInscricao = dataInscricao || usuario.dataInscricao;

    res.status(200).json(usuario);
});

// DELETE: excluir um livro especifico | HTTP DELETE
app.delete('/usuarios/:id', (req, res) => {
    const {id} = req.params;

    const indice = usuarios.findIndex(u => u.id === parseInt(id));

    if (indice === -1) {
        return res.status(404).json({mensagem: 'Usuário não encontrado.'});
    }

    usuarios.splice(indice, 1);

    res.status(204).send();
});

// Iniciar a escuta do servidor na porta especificada
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
