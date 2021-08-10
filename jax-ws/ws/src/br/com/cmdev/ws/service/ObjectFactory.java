
package br.com.cmdev.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.cmdev.ws.service package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AutenticacaoFault_QNAME = new QName("http://service.ws.cmdev.com.br/", "AutenticacaoFault");
    private final static QName _CadastrarItem_QNAME = new QName("http://service.ws.cmdev.com.br/", "CadastrarItem");
    private final static QName _CadastrarItemResponse_QNAME = new QName("http://service.ws.cmdev.com.br/", "CadastrarItemResponse");
    private final static QName _ListarItensPorFiltro_QNAME = new QName("http://service.ws.cmdev.com.br/", "ListarItensPorFiltro");
    private final static QName _ListarTodosItens_QNAME = new QName("http://service.ws.cmdev.com.br/", "ListarTodosItens");
    private final static QName _Filtros_QNAME = new QName("http://service.ws.cmdev.com.br/", "filtros");
    private final static QName _Item_QNAME = new QName("http://service.ws.cmdev.com.br/", "item");
    private final static QName _Itens_QNAME = new QName("http://service.ws.cmdev.com.br/", "itens");
    private final static QName _ListaItens_QNAME = new QName("http://service.ws.cmdev.com.br/", "listaItens");
    private final static QName _TodosItens_QNAME = new QName("http://service.ws.cmdev.com.br/", "todosItens");
    private final static QName _Token_QNAME = new QName("http://service.ws.cmdev.com.br/", "token");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.cmdev.ws.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CadastrarItem }
     * 
     */
    public CadastrarItem createCadastrarItem() {
        return new CadastrarItem();
    }

    /**
     * Create an instance of {@link CadastrarItemResponse }
     * 
     */
    public CadastrarItemResponse createCadastrarItemResponse() {
        return new CadastrarItemResponse();
    }

    /**
     * Create an instance of {@link ListarItensPorFiltro }
     * 
     */
    public ListarItensPorFiltro createListarItensPorFiltro() {
        return new ListarItensPorFiltro();
    }

    /**
     * Create an instance of {@link ListarTodosItens }
     * 
     */
    public ListarTodosItens createListarTodosItens() {
        return new ListarTodosItens();
    }

    /**
     * Create an instance of {@link Filtros }
     * 
     */
    public Filtros createFiltros() {
        return new Filtros();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link Itens }
     * 
     */
    public Itens createItens() {
        return new Itens();
    }

    /**
     * Create an instance of {@link ListaItens }
     * 
     */
    public ListaItens createListaItens() {
        return new ListaItens();
    }

    /**
     * Create an instance of {@link TodosItens }
     * 
     */
    public TodosItens createTodosItens() {
        return new TodosItens();
    }

    /**
     * Create an instance of {@link TokenUsuario }
     * 
     */
    public TokenUsuario createTokenUsuario() {
        return new TokenUsuario();
    }

    /**
     * Create an instance of {@link Filtro }
     * 
     */
    public Filtro createFiltro() {
        return new Filtro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "AutenticacaoFault")
    public JAXBElement<String> createAutenticacaoFault(String value) {
        return new JAXBElement<String>(_AutenticacaoFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarItem }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CadastrarItem }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "CadastrarItem")
    public JAXBElement<CadastrarItem> createCadastrarItem(CadastrarItem value) {
        return new JAXBElement<CadastrarItem>(_CadastrarItem_QNAME, CadastrarItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarItemResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CadastrarItemResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "CadastrarItemResponse")
    public JAXBElement<CadastrarItemResponse> createCadastrarItemResponse(CadastrarItemResponse value) {
        return new JAXBElement<CadastrarItemResponse>(_CadastrarItemResponse_QNAME, CadastrarItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarItensPorFiltro }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarItensPorFiltro }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "ListarItensPorFiltro")
    public JAXBElement<ListarItensPorFiltro> createListarItensPorFiltro(ListarItensPorFiltro value) {
        return new JAXBElement<ListarItensPorFiltro>(_ListarItensPorFiltro_QNAME, ListarItensPorFiltro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarTodosItens }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarTodosItens }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "ListarTodosItens")
    public JAXBElement<ListarTodosItens> createListarTodosItens(ListarTodosItens value) {
        return new JAXBElement<ListarTodosItens>(_ListarTodosItens_QNAME, ListarTodosItens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Filtros }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Filtros }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "filtros")
    public JAXBElement<Filtros> createFiltros(Filtros value) {
        return new JAXBElement<Filtros>(_Filtros_QNAME, Filtros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Item }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Itens }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Itens }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "itens")
    public JAXBElement<Itens> createItens(Itens value) {
        return new JAXBElement<Itens>(_Itens_QNAME, Itens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaItens }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListaItens }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "listaItens")
    public JAXBElement<ListaItens> createListaItens(ListaItens value) {
        return new JAXBElement<ListaItens>(_ListaItens_QNAME, ListaItens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TodosItens }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TodosItens }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "todosItens")
    public JAXBElement<TodosItens> createTodosItens(TodosItens value) {
        return new JAXBElement<TodosItens>(_TodosItens_QNAME, TodosItens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TokenUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.cmdev.com.br/", name = "token")
    public JAXBElement<TokenUsuario> createToken(TokenUsuario value) {
        return new JAXBElement<TokenUsuario>(_Token_QNAME, TokenUsuario.class, null, value);
    }

}
